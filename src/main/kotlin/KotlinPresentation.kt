/**
 * Kotlin Language for Java Developer
 *
 * 2010 : Created by Jetbreains
 * 2016 : Kotlin 1.0 released
 * 2017 : Kotlin is officially supported by Google on Android.
 * 2018 : Kotlin is officially the main language by Google on Android.
 *
 * Best of many languages, not really new stuffs : Java, C#, Groovy, Scala ...
 * Very pragrammatic language.
 *
 * Statically Typed (more than Java).
 *
 *  Compiles
 *  - Java (1.0)
 *  - JavaScript (1.1)
 *  - Native (1.3) beta
 *
 *  Fluent and a lot of cool features.
 *
 *  Let's go to see code.
 *
 */

























/**
 * The classical Hello World
 *
 * - val / var myVariable : Type = Type()       // Like Scala
 * - Type Inference                             // Like Scala
 * - No semi-column                             // Like Groovy
 * - String multiline                           // Like Groovy, Java 12
 * - String template                            // Like Groovy
 *
 */
fun main1(args: Array<String>) {
    val world = "World"
    println("Hello $world")
}


































/**
 * Expression vs Statement
 * Functional is more expression // Like functional language
 *
 * - if expression             // Like Scala
 *  - for in / forEach loop     // Like C#
 *  - when pattern matching     // Like Scala, Java 12-13 ?
 *
 */
fun main2(args: Array<String>) {
    val age = 11
    val drinkForYouParty = if (age >= 18) "Tequila !!!" else "Champomy :-("
    println(drinkForYouParty)

    for (currentAge in 1 until age) {
        println("Do a $currentAge birthday party with $drinkForYouParty")
    }

    for (currentAge in 1..age) {
        println("Do a $currentAge birthday party with $drinkForYouParty")
    }

    listOf(1, 2).forEach({
        print("Just a loop as functional way")
    })

    val reductionPct = when (age) {
        in 1..3 -> 100
        in 4..11 -> 75
        in 12..24 -> 50
        in 25..60 -> 0
        //is Int -> 50
        else -> 50
    }
    println("Train Reduction Percentage = $reductionPct")
}












/**
 * Function Declaration        // Like Scala
 * - Default arguments         // Like Scala / C#
 * - Single-Return arguments   // Like future Java 12
 */
fun sayMyName(firstName: String, lastName: String, greet: String = "HI"): String {
    return "${greet} ${firstName.toUpperCase()} ${lastName.toUpperCase()}"
}

fun main3(args: Array<String>) {
    println(sayMyName("Alexandre", "Navarro", "HI"))
    println(sayMyName(firstName = "Alexandre", lastName = "Navarro", greet = "HI"))
    println(sayMyName(lastName = "Navarro", firstName = "Alexandre"))
}


































/**
 * * Lambda
 * - classical filter map                                       // Like Java cautiou It is a stream, the return is a List
 * - if lamba is last parameter, you can remove parenthesis     // Don't think any language do that
 * - it is a default parameter of a lambda                      // Like Groovy
 */

fun main4(args: Array<String>) {
    var numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val square = { x: Int -> x + x }
    numbers .filter({ e -> e % 2 == 0 })
            .map(square)
            .forEach({
                println(it)
            })
}
































/**
 * Extentions methods
 * - add a method to existing class you don't write // Like C#
 *
 * Caution, use notably on String
 *
 */
fun String.speakLoud() = toUpperCase()

fun main5(args: Array<String>) {
    println("Say my name".speakLoud())
}




































/**
 * Type System                          // Not like any language, see ASCIART
 * - Everything inherits from Any?
 * - Nothing is child of any Object
 * - Null Safety                        // No language as today (maybe in the fufure in C#)
 * - Elvis Operator                     // + or - like Groovy
 * - Safe Cast
 *
 *
 *         +----------------------------------+                                +----------------------------------+
 *         |               Any                |------------------------------->|               Any?               |
 *         +----------------------------------+                                +----------------------------------+
 *          ^    ^       ^                  ^                                     ^    ^     ^                  ^
 *          |    |       |                  |                                     |    |     |                  |
 *     +----|--+-|-----+-|----------------+-|--------------------------------+----|--+-|---+-|----------------+ |
 *     |    |  | |     | |                | |                                |    |  | |   | |                | |
 *     |    |  | |     | |                | |                                v    |  v |   v |                v |
 * +--------+ +-----+ +------+        +-------+                        +--------+ +-----+ +------+        +-------+
 * | String | | Int | | Unit |        | Fruit |                        | String?| | Int?| | Unit?|        | Fruit?|
 * +--------- +------ +------+        +--------                        +--------- +------ +------+        +-------+
 *          ^    ^    ^               ^     ^                                  ^    ^    ^               ^     ^
 *          |    |    |               |     |                                  |    |    |               |     |
 *          |    |    |             +-|-----|-+--------------------------------------------------------+-|-----|-+
 *          |    |    |             | |     | |                                |    |    |             | |     | |
 *          |    |    |             | |     | |                                |    |    |             v |     | v
 *          |    |    |         +--------+ +-------+                           |    |    |         +--------+ +-------+
 *          |    |    |         | Banana | | Peach |                           |    |    |         | Banana?| | Peach?|
 *          |    |    |         +--------+ +-------+                           |    |    |         +--------+ +-------+
 *          |    |    |          ^           ^                                 |    |    |          ^           ^
 *          |    |    |          |           |                                 |    |    |          |           |
 *          |    |    |          |           |                                 |    |    |          |           |
 *          +---------------------------------+                                +---------------------------------+
 *          |             Nothing             |------------------------------->|             Nothing?            |
 *          +---------------------------------+                                +---------------------------------+
 *
 *
 *
 */










fun main6(args: Array<String>) {

    // Not nullable instanceq
    var notNullableString: String = "abc"
    //a = null // compilation error

    // Nullable instance
    var nullableString: String? = "abc"
    nullableString = null // ok
    print(nullableString)

    // Length of Not Nullable String
    val lengthOfNotNullableString = notNullableString.length

    // val lengthOfNullableString = nullableString.length //  // error: variable 'nullableString' can be null
    println(nullableString?.length)

    // Elvis Operator
    val lengthOfNullableString = nullableString?.length ?: -1

    // !! Operator (Unknown Nullable instance)
    val lengthOfUnknonNullableString = nullableString!!.length

    // Safe Cast
    val aInt: Int? = notNullableString as? Int
}






















/**
 * Class / Object
 * - final by default           // See Java Effective
 * - properties
 * - constructor
 * - object
 * - companion Object
 */

enum class Sex {
    MALE, FEMALE
}

class FootballPlayer(val firstName: String, val lastName: String, var club: String, val sex: Sex = Sex.MALE)

object FootballUtil {
    fun isOlympiqueDeMarseilleFootballPlay(player: FootballPlayer) = player.club == "Olympique de Marseille"

}

fun main7(args: Array<String>) {
    val famousFootballPlayer = FootballPlayer("Kylian", "Mbappé", "PSG")
    println(famousFootballPlayer.firstName)
    //famousFootballPlayer.lastName = "Another name"
    println(FootballUtil.isOlympiqueDeMarseilleFootballPlay(famousFootballPlayer))
}






















/**
 * Infix
 *
 */

data class Food(val name: String)

fun FootballPlayer.eat(food: Food) {
    println("this.firstName is eating $food")
}

fun main8(args: Array<String>) {
    val andrePierreGignac = FootballPlayer("André-Pierre", "Gignac", "Olympique de Marseille")
    andrePierreGignac.eat(Food("Big Mac"))
}

































/**
 * Operator
 * - You can redefine only some operator, it is just method alias
 */

// Unary prefix operators
//+a 	a.unaryPlus()
//-a 	a.unaryMinus()
//!a 	a.not()

// Binary operations
// a + b 	a.plus(b)
// a - b 	a.minus(b)
// a * b 	a.times(b)
// a / b 	a.div(b)
// a % b 	a.rem(b), a.mod(b) (deprecated)
// a..b 	a.rangeTo(b)

// In operator
//a in b 	b.contains(a)
//a !in b 	!b.contains(a)

//Indexed access operator
//a[i] 	a.get(i)
//a[i, j] 	a.get(i, j)
//a[i_1, ..., i_n] 	a.get(i_1, ..., i_n)
//a[i] = b 	a.set(i, b)
//a[i, j] = b 	a.set(i, j, b)
//a[i_1, ..., i_n] = b

// Invoke operator
//a() 	a.invoke()
//a(i) 	a.invoke(i)
//a(i, j) 	a.invoke(i, j)
//a(i_1, ..., i_n) 	a.invoke(i_1, ..., i_n)

// Augmented assignments
// a += b 	a.plusAssign(b)
// a -= b 	a.minusAssign(b)
// a *= b 	a.timesAssign(b)
// a /= b 	a.divAssign(b)
// a %= b 	a.remAssign(b), a.modAssign(b) (deprecated)

// Equality and inequality operators
//a == b 	a?.equals(b) ?: (b === null)
//a != b 	!(a?.equals(b) ?: (b === null))


/**
 * DSL
 * - infix
 * - operator
 * - extentions
 * - lambda on last parameter with receiver
 *
 *
 */
fun main9(args: Array<String>) {
    val result =
            html {
                head {
                    title { +"HTML encoding with Kotlin" }
                }
                body {
                    h1 { +"HTML encoding with Kotlin" }
                    p { +"this format can be used as an alternative markup to HTML" }

                    // an element with attributes and text content
                    a(href = "http://jetbrains.com/kotlin") { +"Kotlin" }

                    // mixed content
                    p {
                        +"This is some"
                        b { +"mixed" }
                        +"text. For more see the"
                        a(href = "http://jetbrains.com/kotlin") { +"Kotlin" }
                        +"project"
                    }
                    p { +"some text" }

                    // content generated from command-line arguments
                    p {
                        +"Command line arguments were:"
                        ul {
                            for (arg in args)
                                li { +arg }
                        }
                    }
                }
            }
    println(result)
}

interface Element {
    fun render(builder: StringBuilder, indent: String)
}

class TextElement(val text: String) : Element {
    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent$text\n")
    }
}

abstract class Tag(val name: String) : Element {
    val children = arrayListOf<Element>()
    val attributes = hashMapOf<String, String>()

    protected fun <T : Element> initTag(tag: T, init: T.() -> Unit): T {
        tag.init()
        children.add(tag)
        return tag
    }

    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent<$name${renderAttributes()}>\n")
        for (c in children) {
            c.render(builder, indent + "  ")
        }
        builder.append("$indent</$name>\n")
    }

    private fun renderAttributes(): String? {
        val builder = StringBuilder()
        for (a in attributes.keys) {
            builder.append(" $a=\"${attributes[a]}\"")
        }
        return builder.toString()
    }


    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }
}

abstract class TagWithText(name: String) : Tag(name) {
    operator fun String.unaryPlus() {
        children.add(TextElement(this))
    }
}

class HTML() : TagWithText("html") {
    fun head(init: Head.() -> Unit) = initTag(Head(), init)

    fun body(init: Body.() -> Unit) = initTag(Body(), init)
}

class Head() : TagWithText("head") {
    fun title(init: Title.() -> Unit) = initTag(Title(), init)
}

class Title() : TagWithText("title")

abstract class BodyTag(name: String) : TagWithText(name) {
    fun b(init: B.() -> Unit) = initTag(B(), init)
    fun p(init: P.() -> Unit) = initTag(P(), init)
    fun h1(init: H1.() -> Unit) = initTag(H1(), init)
    fun ul(init: UL.() -> Unit) = initTag(UL(), init)
    fun a(href: String, init: A.() -> Unit) {
        val a = initTag(A(), init)
        a.href = href
    }
}

class Body() : BodyTag("body")
class UL() : BodyTag("ul") {
    fun li(init: LI.() -> Unit) = initTag(LI(), init)
}

class B() : BodyTag("b")
class LI() : BodyTag("li")
class P() : BodyTag("p")
class H1() : BodyTag("h1")

class A() : BodyTag("a") {
    public var href: String
        get() = attributes["href"]!!
        set(value) {
            attributes["href"] = value
        }
}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init()
    return html
}



/**
 * Feedback from Kotlin Conf
 *
 * New 1.3
 * - Contract : help compiler to be clever in order not have
 * - Coroutine stable (light thread, write like sequential, run in parallel
 * - Native platform in addition javascript, jvm
 *    - Lot of presentation of cross platform, back-end on kotlin on jv, front-end in kotlin on android, javascrip on web,
 * - Unsigned Number
 */






































/**
 * Some controversal choices
 *
 * - Everything is final, have to add open when needed
 * - Object Singleton, more code than static in Java / C#
 * - Everything is public by default, the reason, the analyse java open source code base more than 80% elements are public
 * - Creation on inner class, weird synthax ' : object', but not very used
 * - !! operator from java, first in the language was ?, but call Java Code was horrible
 *   - now a lot of java libs use @NotNull which helps kotlin to know if it @NotNull or @Null (spring, rxjava)
 * - Not a file by class => difficult to navigate in the code without IDE
 */





































/**
* - Call for Action : Try it.
*   - Really easy for a Java developer
*   - Same IDE, you can transform Java code to Kotlin or the contrary
*   - Can mix Java and Kotlin if you want in the same project
*   - A Way to begin, begin with unit tests
*/









































