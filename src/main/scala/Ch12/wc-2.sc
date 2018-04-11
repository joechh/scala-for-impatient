import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.JButton

//12.7 SAM Interface
var counter = 0
val button = new JButton("Increment")
button.addActionListener(new ActionListener {
  override def actionPerformed(e: ActionEvent): Unit =
    counter += 1
})

button.addActionListener(event => counter += 1)
val exit = (event: ActionEvent) => if (counter > 9) System.exit(0)
button.addActionListener(exit(_))

//12.8 Curring
val mul = (x: Int, y: Int) => x * y
val mulOneAtATime = (x: Int) => ((y: Int) => x * y)
mulOneAtATime(6)(7)

//when using def, there is a shortcut for defining currying function
def mulOneAtATimeV2(x: Int)(y: Int) = x * y
mulOneAtATimeV2(2)(3)

//Error when using similar syntax in val
//val mulOneAtATimeV3 = (x: Int)(y: Int) =>  x * y

//typical example for currying
val a = Array("Hello", "World")
val b = Array("hello", "world")
a.corresponds(b)(_.equalsIgnoreCase(_))

//12.9 Control Abstraction
def runInThread(block: () => Unit): Unit = {
  new Thread {
    override def run() {
      block()
    }
  }.start()
}

//runInThread(() => {
//  println("Hi"); Thread.sleep(1000); println("bye")
//})

def runInThreadCallByName(block: => Unit): Unit = {
  new Thread {
    override def run() {
      block
    }
  }.start()
}

//runInThreadCallByName({
//  println("Hi");
//  Thread.sleep(1000);
//  println("bye")
//})

//12.10 return expression
def until(block: => Unit): Unit = {
  block
}
def test(value: Int): Int = {
  until(
    if (value > 10) return 10
    else return -10
  )

  return -1
}
test(1)



