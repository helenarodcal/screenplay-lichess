class Actor(
    var hasPerformedTask: Boolean = false,
    var hasAnsweredQuestion: Boolean = false,
    var canAnswerQuestions: Boolean = false
) {
    fun perform(performable: Performable) {
        performable.perform()
        hasPerformedTask = true
    }

    fun asks(question: Question): Any {
        val answer = question.answer()
        hasAnsweredQuestion = true
        return answer
    }


    val ability: Ability? = object : Ability {}
}