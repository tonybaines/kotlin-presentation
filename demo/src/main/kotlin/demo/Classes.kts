package demo

import sun.security.jca.GetInstance
import java.time.Instant


val Kerry = Speaker("Kerry Buckley")
val Neil = Speaker("Neil Winton")
val MarkB = Speaker("Mark Barham")
val Ben = Speaker("Ben Thorner")
val Alasdair = Speaker("Alasdair MacLeod")
val MarkP = Speaker("Mark Power")
val MarkA = Speaker("Mark Attree")
val Simon = Speaker("Simon Thompson")
val Tony = Speaker("Tony Baines")

val talks = listOf(
        Talk("09:40 a.m", "Learning something from nothing – Indentation and complexity", Neil),
        Talk("10:30 a.m", "CI for the Software Developer", MarkB),
        Talk("11:15 a.m", "Move Your Data With Apache NiFi", Ben),
        Talk("12:00 a.m", "Agility in UKB – brief update and call for experience", Alasdair),
        Talk("12:15 p.m", "Project DaVinci update", MarkP),
        Talk("13:30 p.m", "A Lightning Talk: Programming Drones for search and rescue", MarkA),
        Talk("13:45 p.m", "New AI things  ", Simon),
        Talk("14:45 p.m", "Kotlin – Java++ ?", Tony),
        Talk("15:30 p.m", "Everything I don’t know about software development", Kerry)
)

val devcon11 = Conference(date = "2017-11-24", talks = talks)

data class Talk(val time: String, val subject: String, val speaker: Speaker)
data class Conference(val date: String, val venue: String = "Adastral Park", val talks: List<Talk>)
data class Speaker(val name: String)

devcon11.talks.filter { talk -> talk.speaker.name.startsWith("Mark") }.forEach{println(it)}

devcon11.talks.inTheAfternoon()
        .forEach{println(it)}



fun List<Talk>.inTheAfternoon() =
        this.filter { it.time.contains("p.m") }


val isTrue = if (true) true else (false)



"Today is ${Instant.now()}"

"Tony" == "Tony"