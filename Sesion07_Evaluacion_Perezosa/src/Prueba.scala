import java.io._
import scala.io.Source

/*
 * Ejercicio 1
 * 1. Llenar un archivo de forma aleatoria con lineas de 1 y 0 q identifican las imagenes de matriculas tomadas por una 
 * camara y almacenadas en dicho archivo
 * Un millon de 1 y 0s
 * Un millon de matriculas
 * 
 * 2 Leer el archivo y buscar en cada linea patrones de 10 1 juntos
 * 
 * 3. Implementar funciones CBV y CBN para medir los tiempos de analisis
 */

object Prueba {
  
  def main(args: Array[String]): Unit = {
    
    
    def AnalisisCBV(l:Iterator[String]) : Unit = {
    var contUnos = 0;
    var contConjuntos = 0;
    
    while(l.hasNext){
      var str = l.next().toString()
      for(x <- 0 to str.length-100){
        for(y <- x to x+99){
          if(str.substring(y, y+1)=="1"){
            contUnos+=1
            //println(contUnos)
          }
          if(contUnos==4){
            contConjuntos+=1
          }
        }
        contUnos=0
      }
    }
    println("Contidad de conjuntos de 100 unos: "+contConjuntos)
  }
    def AnalisisCBN(l : => Iterator[String]) : Unit = {
    var contUnos = 0;
    var contConjuntos = 0;
    
    while(l.hasNext){
      var str = l.next().toString()
      for(x <- 0 to str.length-100){
        for(y <- x to x+99){
          if(str.substring(y, y+1)=="1"){
            contUnos+=1
            //println(contUnos)
          }
          if(contUnos==4){
            contConjuntos+=1
          }
        }
        contUnos=0
      }
    }
    println("Contidad de conjuntos de 100 unos: "+contConjuntos)
  }
    
    def analizarDatos : String = {
    println("Analizando Imagen")
    "Cadena de caracteres resultante"
  }
  
  def iniciarAnalisisCBV(iniciar : Boolean, datos : String) : String = {
    println("Iniciando analisis CBV")
    iniciar match {
      case true => "Si Analizar"
      case false => "Si Analizar"
        
    }
  }
  def iniciarAnalisisCBN(iniciar : Boolean, datos : => String) : String = {
      println("Iniciando analisis CBN")
      iniciar match {
        case true => "Si Analizar"
        case false => "Si Analizar"
      }
    }
  
  def printToFile(f: java.io.File)(op: java.io.PrintWriter => Unit) {
    val p = new java.io.PrintWriter(f)
    try { op(p) } finally { p.close() } 
    }
  
  def escribirArchivo(data : Array[String]) : Unit = {
    printToFile(new File("src/arc.txt")) {
    p => data.foreach(p.println)
    }
  }
  
  def generarNumeros() : Array[String] = {
    var v = new Array[String](1000)
    var temp = ""
    for(x<-0 to 999 by 1){
      v(x)=numRandom()
    }
    v
  }
  
  def numRandom() : String = {
    var num = scala.util.Random
    var s = ""
    for(x<-0 to 999 by 1){
      s += num.nextInt(2)
    }
    s
  }
  
  var x = Array("Albar", "Hola Mundo")
  escribirArchivo(generarNumeros())
  
  
  val lineas = scala.io.Source.fromFile ("src/arc.txt").getLines
  println("Analisis CBV")
  val t0 = System.nanoTime()
  AnalisisCBV(lineas)
  val t1 = System.nanoTime()
  println("CBV tardo: "+(t1-t0)+"ns")
  println("===============================")
  
  val lineas2 = scala.io.Source.fromFile ("src/arc.txt").getLines
  println("Analisis CBN")
  val t2 = System.nanoTime()
  AnalisisCBN(lineas2)
  val t3 = System.nanoTime()
  println("CBN tardo: "+(t3-t2)+"ns")
  
  }//main

}