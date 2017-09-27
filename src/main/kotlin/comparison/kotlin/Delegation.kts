package comparison.kotlin

interface WalkAbility {
  fun walk()
}
object WalkMixin: WalkAbility {
  override fun walk() {}
}
interface FlyAbility {
  fun fly()
}
object FlyMixin: FlyAbility {
  override fun fly() {}
}
interface SwimAbility {
  fun swim()
}
object SwimMixin: SwimAbility {
  override fun swim() {}
}

class Duck(w: WalkAbility, f: FlyAbility, s: SwimAbility)
  : WalkAbility by w, FlyAbility by f, SwimAbility by s
class Penguin(w: WalkAbility, s: SwimAbility)
  : WalkAbility by w, SwimAbility by s


val duck = Duck(WalkMixin, FlyMixin, SwimMixin)
duck.fly()
duck.walk()
duck.swim()

val penguin = Penguin(WalkMixin, SwimMixin)
penguin.walk()
penguin.swim()