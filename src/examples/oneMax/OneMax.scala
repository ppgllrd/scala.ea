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


case class OneMax(numVars : Int) extends Problem {
  override def isOptimal(ind: Individual): Boolean =
    ind.fitness == numVars

  override def computeFitness(ind: Individual): Fitness =
    ind.chromosome.count(_==1)
}


object OneMaxEA extends App {
  // Use English formats
  Locale.setDefault(new Locale.Builder().setLanguage("en").setRegion("US").build())

  val numVars = 500 // number of variables
  val p = OneMax(numVars)

  val ea = StandardSteadyStateTimedEA(seed = 0, problem = p, maxRunTime = 1000)

  val result = ea.run()

  print("Final solution: "+result.best)
}

