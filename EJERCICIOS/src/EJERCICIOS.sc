//Pregunta 1
//Transforme el siguiente método Java desarrollado de forma imperativa a una versión funcional utilizando Scala.
//double myMethod(List<Double> datos) {
//    double suma = 0.0;
//    for (int i = 0; i < datos.size(); i++) {
//        suma += datos.get(i);
//    }
//    double promedio = suma / datos.size();
//    double sumaCuadrados = 0.0;
//    for (int i = 0; i < datos.size(); i++) {
//        double diferencia = datos.get(i) - promedio;
//        sumaCuadrados += diferencia * diferencia;
//    }
//    return Math.sqrt(sumaCuadrados / datos.size());
//}
val datos: List[Double] = List(1.0, 2.0, 3.0, 4.0, 5.0)

def myMethod(datos: List[Double]): Double = {
  val promedio = datos.map(n => n).sum / datos.size
  val sumaCuadrados = datos.map(n => {
    val diferencia = n - promedio
    diferencia * diferencia
  }).sum
  Math.sqrt(sumaCuadrados / datos.size)
}
myMethod(datos)

//Pregunta 2
//Transformación de calificaciones
//En una asignatura universitaria se manejan listas de calificaciones numéricas que, antes de ser
// registradas oficialmente, deben pasar por un proceso de transformación que puede variar según
// la política del docente. Algunas veces se requiere redondear cada calificación, otras veces
// aplicar una bonificación, y en ocasiones disminuir ligeramente aquellas calificadas demasiado
// altas. Se desea crear una solución en la que exista una función capaz de recibir tanto la
// lista de calificaciones como la lógica específica de transformación que se quiera aplicar,
// de manera que dicha función pueda reutilizarse con diferentes políticas. La función deberá
// producir una nueva lista con las calificaciones ya transformadas según la política que se
// envíe al momento de usarla.

val calificaciones: List[Double] = List(6.5, 7.8, 9.2, 8.4, 5.9)

def redondear: Double => Double = _.round.toDouble
def bonificar: Double => Double = _ + 1.0
def disminuirAltas: Double => Double  = c => if (c > 8.0) c - 1.0 else c
def transformarCalificaciones(califs: List[Double], politica: Double => Double): List[Double] = califs.map(politica)
transformarCalificaciones(calificaciones, redondear)
transformarCalificaciones(calificaciones, bonificar)
transformarCalificaciones(calificaciones, disminuirAltas)
//Pregunta 3
//Transforme la función anónima a una función con nombre
//val generadorSaludoAnonimo: String => (String => String) =
//  (fraseBase: String) =>
//    (nombre: String) =>
//      s"$fraseBase, $nombre!”
def generadorSalud(fraseBase: String): String => String = {
  (nombre: String) => s"$fraseBase, $nombre!"
}
generadorSalud("Hola")("Luis")
