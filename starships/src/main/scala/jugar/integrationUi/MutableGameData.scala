package jugar.integrationUi

import entity.Entity
import entity.value.{Collision, KeyPress}
import gameData.implementation.DefaultGameData
import spawner.Spawner

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Map

class MutableGameData(var gameData: DefaultGameData):

  def addCollision(collision: Collision): Unit =
    gameData = gameData.copy(collisions =  collision :: gameData.collisions)

  def addKeyStrokes(keyStrokes: List[KeyPress]): Unit =
    gameData = gameData.copy(keyStrokes =  keyStrokes)

  def flush(): Unit =
    gameData.copy(collisions = List(), keyStrokes = List())

