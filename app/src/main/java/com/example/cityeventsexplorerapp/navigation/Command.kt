package com.example.cityeventsexplorerapp.navigation

import androidx.navigation.NavDirections

sealed interface Command {
    object FinishAppCommand : Command
    object NavigateUpCommand : Command
    class NavCommand(val navDirections: NavDirections) : Command
}