package com.web.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    /*
    find all information of books
    */
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Page<Book> findAllbyPage(int pageNum, int size){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNum, size, sort);
        return bookRepository.findAll(pageable);
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }

    public Optional<Book> findOne(long id){
        return  bookRepository.findById(id);
    }

    public void delete(long id){
        bookRepository.deleteById(id);
    }

    public List<Book> findByAuthorAndStatus(String author, int status){
        return bookRepository.findByAuthorAndStatus(author, status);
    }

    public int updateStatusById(int status, long id){
        return bookRepository.updateByJPQL(status, id);
    }


}
