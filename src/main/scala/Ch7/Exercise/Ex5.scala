package A.B.C.D {

  object TestClass {
    private[B] def openShow() = print("show")

    private def closeShow() = print("show")
  }

}

package A {

  class AClass {
    //cannot find openShow
    //TestClass.openShow()
  }
  package B {

    import A.B.C.D.TestClass

    class BClass {
      TestClass.openShow()
    }

    package C {

      //class under package B can still see private function that open to B
      class CClass {
        TestClass.openShow()
      }

    }

  }

}


