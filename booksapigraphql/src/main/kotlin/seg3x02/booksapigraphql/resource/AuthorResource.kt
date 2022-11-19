package seg3x02.booksapigraphql.resource

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import seg3x02.booksapigraphql.entity.Author
import seg3x02.booksapigraphql.resolvers.AuthorMutationResolver
import seg3x02.booksapigraphql.resolvers.AuthorQueryResolver

//YasinJ
class AuthorResource(val AuthorQueryResolver: AuthorQueryResolver, val AuthorMutationResolver:AuthorMutationResolver) {

    @GetMapping
    fun index(): List<Author> = AuthorQueryResolver.authors(bookNumber = 0)


    @PostMapping
    fun post(@RequestBody author: Author){
        AuthorMutationResolver.newAuthor(author.bookNumber,author.firstName,author.lastName)
    }


}