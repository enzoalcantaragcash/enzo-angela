package creational.prototype

import org.junit.Assert.*
import org.junit.Test

class TestPrototype {
    @Test
    fun checkInstanceOfOrganization() {
        val org = Organization()
        val community = org.clone()
        assertTrue(community is Organization)
    }

    @Test
    fun checkInstanceOfCompany() {
        val companyA = Company()
        val companyB = companyA.clone()
        assertTrue(companyB is Company)
    }

    @Test
    fun checkDifferentInstancesOfOrg() {
        val org = Organization()
        val community = org.clone()
        assertFalse(community == org)
    }

    @Test
    fun checkDifferentInstancesOfCompany() {
        val companyA = Company()
        val companyB = companyA.clone()
        assertFalse(companyA == companyB)
    }
}