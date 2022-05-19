package creational.prototype

private val organizationCache = HashMap<String, Organization>()

open class Organization : Cloneable {
    var id : Int = -1
    var name : String = ""
    var address : String = ""

    public override fun clone(): Any {
        var clone: Any? = null
        try {
            clone = super.clone()
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }
        return clone!!
    }
}

class Community : Organization()

class Company : Organization()

fun main(args: Array<String>) {
    var org: Organization = Community()
    org.name = "PADC"
    org.id = 1
    org.address = "Phil"

    organizationCache[org.name] = org
    org = Company()
    org.name = "Sea"
    org.id = 1
    org.address = "Malay"

    organizationCache[org.name] = org
    val company = organizationCache["Sea"]!!.clone() as Company
    println(company.name + company.address)
    println(organizationCache["Sea"].toString())
}