object TrafficLightColor extends Enumeration {
  //Value(id:Int,name:String)
  val Red: Value = Value(0, "Stop")
  val Yellow: Value = Value(10) // The default name is the field name
  val Green = Value("Go") //id would be auto-gen vai nextId
}

TrafficLightColor.Red
TrafficLightColor.Yellow
TrafficLightColor.Green

//alias type Value to TrafficLightColor for hiding Value

//color: TrafficLightColor = color:TrafficLightColor.TrafficLightColor( which is alias of Value)
object TrafficLightColor2 extends Enumeration {
  //Value(id:Int,name:String)
  type TrafficLightColor2 = Value
  val Red: Value = Value(0, "Stop")
  val Yellow: Value = Value(10) // The default name is the field name
  val Green = Value("Go") //id would be auto-gen vai nextId
}

import TrafficLightColor2._

def doWhat(color: TrafficLightColor2) = color match {
  case Red => "stop"
  case Yellow => "hurry up"
  case _ => "go"
}
doWhat(Yellow)

//return Value Set
TrafficLightColor.values
for (c <- TrafficLightColor.values) println(s"${c.id}:${c.toString}")
//Lookup Value by id or name
TrafficLightColor(0)
TrafficLightColor.withName("Go")
