import javax.sound.sampled.Line

class TelephoneLine(val number: String) {

    private val line: Line = Line()

    fun liftHandset()

    fun dial(destination: String) : Call = {...}

}