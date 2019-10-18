package lectures.part6Futures

import java.util.concurrent.{ExecutorService, Executors}

object Exersices extends App{

  // constract 50 threads "inception" from thread
  // Treads1 => Treads2=>Treads3... and calls all treads in reverse order

  def inceptionThreads (maxThreads: Int, i:Int=1): Thread =new Thread(()=>{
    if(i<maxThreads) {
      val newThread = inceptionThreads(maxThreads,i+1)
      newThread.start()
      newThread.join() // join threads to stack
    }
    println(s"Hello from thread $i")
  })

  inceptionThreads(50).start()

  // change x by 100 thrads
  var x =0
  val threads = (1 to 100).map(_=>new Thread(()=>x+=1))
  threads.foreach(_.start())
 threads.foreach(_.join())
  println(x)



}
