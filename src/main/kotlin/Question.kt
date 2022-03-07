interface Question {
    fun answer(): Any

    fun answeredBy(actor: Actor): Any
}
