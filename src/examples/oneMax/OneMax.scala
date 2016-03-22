/******************************************************************************
  *
  * One Max problem: maximize number of 1s in a binary string
  *
  * @ Pepe Gallardo, 2016
  *
  *****************************************************************************/

package examples.oneMax

import java.util.Locale
import EA._

case class OneMax(val numberVars : Int) extends Problem {
  override def isOptimal(xs: Chromosome): Boolean =
    xs.count(_==1) == numberVars

  override def evalSolution(xs: Chromosome): Fitness =
    xs.count(_==1)
}


object OneMaxGA extends App {
  // Use English formats
  Locale.setDefault(new Locale.Builder().setLanguage("en").setRegion("US").build())

  val n = 500 // number of variables
  val p = OneMax(n)

  val ga = StandardSteadyStateEA(seed = 0, problem = p, maxRunTime = 1000)

  val best = ga.run()

  print("Final solution: "+best)
}

