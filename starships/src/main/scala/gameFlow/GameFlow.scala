package gameFlow

import action.Action
import actionSource.ActionSource
import gameData.PlayingGameData

case class GameFlow(actionSources: List[ActionSource]):
  def nextFrame(gameData: PlayingGameData): PlayingGameData =
    val actions = actionSources.foldLeft(List(): List[Action])((acc, actionSource) =>
      acc.appendedAll(actionSource.createActions(gameData)))
    actions.foldLeft(gameData)((gameData,action) => action.act(gameData))
