package Ch7.Exercise


package com {
  package horstmann {

    object Utils {
      val defaultValue = 1
    }
    package impatient {
    }

  }

}

package com.horstmann.impatient {

  class A {
    //cannot know Utils.defaultValue(invisibility)
    //val value=Utils.defaultValue
  }

}

package com {
  package horstmann {
    package impatient {

      class B {
        //know Utils.defaultValue(invisibility)
        val value = Utils.defaultValue
      }

    }

  }

}