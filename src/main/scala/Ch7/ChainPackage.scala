package Ch7

//fake collection
package A {
  package collection {
  }

}

//affected
package A {
  package B {
    package C {

      class test {
        //val array = new collection.mutable.ArrayBuffer[Int](10)
        //Sol, give absolute package path
        val array = new scala.collection.mutable.ArrayBuffer[Int](10)

      }

    }

  }

}

//non-affected by chain package, class/object in A and B is not visible for ones in package C
package A.B {
  package C {

    class test2 {
      val array = new collection.mutable.ArrayBuffer[Int](10)
    }

  }

}

