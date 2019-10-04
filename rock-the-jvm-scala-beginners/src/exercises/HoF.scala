package exercises

object HoF extends App {

/// WetherForecast
case class WeatherForecast(temperatures : Seq[Double]){

 def convertCtoF:Seq[Double] = {
   temperatures.map(temp=>temp*1.8+32)
 }

}
  val weaterForecast = WeatherForecast(List(21,22,23,24,25))
println(weaterForecast.convertCtoF)

  ///// SalariesRaiser
  object SalariesRaiser{
    private def promotion (salari: List[Double], promotionFunction: Double=> Double):List[Double]={
      salari.map(promotionFunction)
    }
    def smallPromotion (salari:List[Double]):List[Double] = {
      promotion(salari, _*1.1) //  x=>x*1.1
    }
    def bigPromotion (salari:List[Double]):List[Double]={
      promotion(salari,x=>x*2)
    }
  }
  val salari = List(10000.0,20000.0,50000.0,100000.0)
  println(SalariesRaiser.bigPromotion(salari))
  println(SalariesRaiser.smallPromotion(salari))

  /// urlBuilder
  def urlBuilder (ssl: Boolean, domainName:String):(String,String)=>String={
    val schema = if(ssl) "https://" else "http://"
    (endpoint:String, query:String)=>s"$schema$domainName/$endpoint?$query"
  }


  val domain = "www.example.com"
  def getUrl = urlBuilder(true,domain)
  val endpoint = "User"
  val query = "id_1"
  val url = getUrl(endpoint,query)
  println(url)
}
