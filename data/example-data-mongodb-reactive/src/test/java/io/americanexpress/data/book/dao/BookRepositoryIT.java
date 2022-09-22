package io.americanexpress.data.book.dao;

import io.americanexpress.data.book.config.BookDataTestConfig;
import io.americanexpress.data.book.entity.BookDocument;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**
 * BookRepositoryIT class runs integration test on local MongoDB instance test database.
 */
@ContextConfiguration(classes = BookDataTestConfig.class)
@DataMongoTest
class BookRepositoryIT {

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void init() {
        bookRepository.deleteAll();
    }

    @Test
    void findAll_givenEmptyBookCollection_expectedNoBooksFound() {
        Flux<BookDocument> bookDocumentFlux = bookRepository.findAll();
        StepVerifier.create(bookDocumentFlux).expectNoAccessibleContext().verifyComplete();
    }

    @Test
    void findAll_givenBookCollection_expectedCollectionNotEmpty() {
        BookDocument entry = createSampleBook();
        bookRepository.save(entry);
        Flux<BookDocument> bookDocumentFlux = bookRepository.findAll();
        StepVerifier.create(bookDocumentFlux).expectNextCount(1).verifyComplete();
    }

    @Test
    void findByTitle_givenBookTitle_expectedBookFound() {
        BookDocument entry = createSampleBook();
        bookRepository.save(entry);
        Flux<BookDocument> bookDocumentFlux = bookRepository.findAll();
        StepVerifier.create(bookDocumentFlux).expectNextMatches(bookDocument -> entry.getTitle().equalsIgnoreCase(bookDocument.getTitle())).verifyComplete();
    }

    private BookDocument createSampleBook() {
        BookDocument bookDocument = new BookDocument();
        bookDocument.setTitle("Alice in Wonderland");
        bookDocument.setAuthor("Lewis Carroll");
        return bookDocument;
    }
}
