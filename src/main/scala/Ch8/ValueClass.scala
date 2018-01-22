package Ch8


class Book(val author: Author, val title: Title) {


  override def toString = s"Book(author=$author, title=$title)"
}

class Title(val title: String) extends AnyVal

object Title {
  def apply(title: String): Title = new Title(title)
}

 class Author(private val author: String) extends AnyVal

private object Author {
  def apply(author: String): Author = new Author(author)
}

object Dev {
  def main(args: Array[String]): Unit = {
    val book = new Book(Author("this is author"), Title("this is title"))
    println(book)

  }
}



