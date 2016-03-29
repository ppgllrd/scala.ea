/******************************************************************************
  *
  * Individuals
  *
  * @ Pepe Gallardo, 2016
  *
  *****************************************************************************/

package EA

trait Individual[Gene] {

  var fitness : Fitness = 0
  val chromosome : Chromosome[Gene]

  def copyFrom(that : Individual[Gene])
}

