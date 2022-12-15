package factory

import actionSource.collision.{CollisionActionSource, RegularCollisionActionSourceConfig}
import actionSource.insideBorder.removeEntity.InsideBorderActionSourceRemoveEntity
import actionSource.insideBorder.{InsideBorderAsteroidActionSourceConfig, InsideBorderShipActionSourceConfig, InsideBorderShotActionSourceConfig, setEntity}
import actionSource.insideBorder.setEntity.InsideBorderActionSourceSetEntity
import actionSource.movement.{ControlledMovementActionSource, InputControlledMovementActionSourceConfig, MoveActionSource, RegularMoveActionSourceConfig}
import actionSource.spawn.{SpawnActionShotSourceConfig, SpawnActionSource, TimedSpawnActionSource, TimedSpawnAsteroidActionSourceConfig}
import factory.actionsource.*
import gameFlow.GameFlow
import seed.IntSeed

case class GameFlowFactory():
  val controlledMovementActionSourceFactory: ControlledMovementActionSourceFactory = ControlledMovementActionSourceFactory()
  val collisionActionSourceFactory: CollisionActionSourceFactory = CollisionActionSourceFactory()
  val moveActionSourceFactory: MoveActionSourceFactory = MoveActionSourceFactory()
  def create(idListSeed: IdListSeed): GameFlow = {
    GameFlow(
      List(
        collisionActionSourceFactory.create
        , controlledMovementActionSourceFactory.create(idListSeed)
        , moveActionSourceFactory.create
              , SpawnActionSource(SpawnActionShotSourceConfig())

      ))
  }

//      , TimedSpawnActionSource(TimedSpawnAsteroidActionSourceConfig())
//      , InsideBorderActionSourceSetEntity(InsideBorderShipActionSourceConfig())
//      , InsideBorderActionSourceRemoveEntity(InsideBorderAsteroidActionSourceConfig())
//      , InsideBorderActionSourceRemoveEntity(InsideBorderShotActionSourceConfig())