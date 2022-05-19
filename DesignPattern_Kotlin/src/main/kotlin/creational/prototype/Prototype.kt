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
//    println("Org as Community: $org")

    organizationCache[org.name] = org
    org = Company()
    org.name = "Sea"
    org.id = 1
    org.address = "Malay"
//    println("Org as Company: $org")

    organizationCache[org.name] = org
    val company = organizationCache["Sea"]!!.clone() as Company
    println(company.name + company.address)
    println(organizationCache["Sea"].toString())

//    println("Org as Company (Cloned): $company")
//    println("Is company an instance of Company class? " + (company is Company))
}