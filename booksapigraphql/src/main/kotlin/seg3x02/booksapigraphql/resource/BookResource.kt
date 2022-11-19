package seg3x02.booksapigraphql.resource

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import seg3x02.booksapigraphql.entity.Book
import seg3x02.booksapigraphql.resolvers.BookMutationResolver
import seg3x02.booksapigraphql.resolvers.BookQueryResolver
//Yasin J
class BookResource(private val bookQueryResolver: BookQueryResolver,
                   private val bookMutationResolver: BookMutationResolver) {

    @GetMapping
    fun index(): List<Book> = bookQueryResolver.books() // FIXME comeback to this one if it doesnt work

    @PostMapping
    fun post(@RequestBody book: Book) {
        bookMutationResolver.newBook(book.bookNumber, book.category, book.title, book.cost, book.year, book.description)
    }

    @PutMapping
    fun update(@RequestBody book: Book) {
        bookMutationResolver.updateBook(
            book.bookId,
            book.bookNumber,
            book.category,
            book.title,
            book.cost,
            book.year,
            book.description
        )
    }

    @DeleteMapping
    fun delete(@RequestBody bookId: String) {
        bookMutationResolver.deleteBook(bookId)
    }

}