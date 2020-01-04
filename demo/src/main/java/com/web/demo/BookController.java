package com.web.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/books/by")
    public int getBy(@RequestParam int status,
                        @RequestParam long id){
        return bookService.updateStatusById(status, id);
    }

    @GetMapping("/index")
    public String toIndex(){
        return "index";
    }


    @GetMapping("/books")
    public String getAll(@RequestParam(defaultValue = "0") int pageNum,
                        @RequestParam(defaultValue = "10") int pageSize,
                         Model model){
        model.addAttribute("page", bookService.findAllbyPage(pageNum, pageSize));
        return "bookList";
    }

    @GetMapping("/books/input")
    public String toInput(Model model){
        model.addAttribute("book", new Book());
        return "newBook";
    }


    @PostMapping("/books/update")
    public String creatNewBook(@RequestParam("id") long id,
                               @RequestParam("name") String name,
                               @RequestParam("author") String author,
                               @RequestParam("description") String description,
                               @RequestParam("status") int status, RedirectAttributes redirectAttributes){
        Book book = new Book();
        book.setId(id);
        book.setAuthor(author);
        book.setDescription(description);
        book.setName(name);
        book.setStatus(status);
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message", book.getName()+" update");
        return "redirect:/books";
    }

    @GetMapping("/books/{id}")
    public String getById(@PathVariable long id, Model model){
        Optional<Book> optionalBook = bookService.findOne(id);
        model.addAttribute("book", optionalBook.orElse(new Book()));
        return "bookDetails";
    }

    @GetMapping("/books/input/{id}")
    public String toUpdateForm(@PathVariable long id, Model model){
        Optional<Book> optionalBook = bookService.findOne(id);
        model.addAttribute("book", optionalBook.orElse(new Book()));
        return "newBook";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteById(@PathVariable long id, RedirectAttributes redirectAttributes){
        Optional<Book> optionalBook = bookService.findOne(id);
        bookService.delete(id);
        redirectAttributes.addFlashAttribute("message", optionalBook.get().getName()+" delete");
        return "redirect:/books";
    }

}
