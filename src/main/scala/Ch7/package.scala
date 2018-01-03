package Ch7

package com {

  object OuterObject {
    def tryAccessThisFunc() {}
  }

  package collection {}

  package horstmann {

    object Utils {
      def percentOf(value: Double, rate: Double) = value * rate / 100
    }


    package impatient {

      class Emplyee {
        def giveRaise(salary: Double, rate: Double) = {
          val raise = Utils.percentOf(salary, rate)
          OuterObject.tryAccessThisFunc()
          raise
          val subordinates = new _root_.scala.collection.mutable.ArrayBuffer[Emplyee]
        }
      }

    }

  }

}

