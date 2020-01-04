package com.web.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Page<Book> findAll(Pageable pageable);

    public List<Book> findByAuthor(String author);

    public List<Book> findByAuthorAndStatus(String author, int status);

    public List<Book> findByDescriptionContains(String description);

    @Query("select b from Book b where length(b.name) > ?1")
    public List<Book> findByJPQL(int len1);

    @Modifying
    @Transactional
    @Query("update Book b set b.status=?1 where b.id=?2")
    public int updateByJPQL(int status, long id);
}
