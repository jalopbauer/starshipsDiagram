package jugar.integrationUi

import edu.austral.ingsis.starships.ui.ElementModel
import entity.Entity
import entity.value.{Collision, KeyPress}
import gameState.PlayingGameState

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Map
import javafx.collections.ObservableMap
import jugar.integrationUi.adapter.EntityAdapter


class MutableGameState(var gameData: PlayingGameState, var elements: ObservableMap[String, ElementModel]):
  val entityAdapter: EntityAdapter = EntityAdapter()

  def addCollision(collision: Collision): Unit =
    gameData = gameData.add(collision)

  def addKeyStrokes(keyPress: KeyPress): Unit =
    gameData = gameData.add(keyPress)

  def flush(): Unit =
    gameData = gameData.flush()

  def update(): Unit =
    gameData.modifiedEntitiesSet.foreach(entityId => {
    val optionalEntity = gameData.entitiesMap.get(entityId)
    if (optionalEntity.isDefined)
      val entityModel = entityAdapter.meThem(optionalEntity.get)
      val id = entityModel.getId
      elements.put(id, entityModel)
  })
