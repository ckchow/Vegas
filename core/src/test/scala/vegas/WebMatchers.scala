package vegas

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.logging.LogType
import java.util.logging.Level

import org.scalatest.Matchers
import vegas.util.WebGenerators

import scala.collection.JavaConverters._

trait WebMatchers extends WebGenerators {
  self: Matchers =>

  def hasNoJsErrors()(implicit webDriver: ChromeDriver) = {
    val logs = webDriver.manage.logs.get(LogType.BROWSER).filter(Level.WARNING).asScala.toList
    logs should be ('empty)
  }

}

