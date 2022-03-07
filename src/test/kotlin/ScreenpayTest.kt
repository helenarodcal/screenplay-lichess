import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class ScreenpayTest {
    @Test
    internal fun `an actor exists`() {
        val actor = Actor()
        assertThat(actor, `is`(not(nullValue())))
    }

    @Test
    internal fun `actor has ability`() {
        val actor = Actor()
        assertThat(actor.ability, `is`(not(nullValue())))
    }

    @Test
    internal fun `actor performs tasks`() {
        val actor = Actor()
        actor.perform(object : Performable {
            override fun perform() {}
        })

        assertThat(actor.hasPerformedTask, `is`(true))
    }

    @Test
    internal fun `actor can ask questions`() {
        val actor = Actor()
        val answer = actor.asks(object : Question {
            override fun answer(): Any {
                return true
            }

            override fun answeredBy(actor: Actor): Any {
                TODO("Not needed here")
            }
        })

        assertThat(answer, `is`(true))
        assertThat(actor.hasAnsweredQuestion, `is`(true))
    }

    @Test
    internal fun `abilities enable questions`() {
        val actor = Actor()
        val question = object : Question {
            override fun answer(): Any {
                return true
            }

            override fun answeredBy(actor: Actor): Any {
                return if (!actor.canAnswerQuestions) throw UnsupportedOperationException()
                else {
                    actor.hasAnsweredQuestion = true
                    true
                }
            }
        }

        val answer = question.answeredBy(actor)

        assertThat(answer, `is`(true))
        assertThat(actor.hasAnsweredQuestion, `is`(true))
    }
}