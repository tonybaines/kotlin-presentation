package demo.selenium

import kz.qwertukg.*
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

driver(ChromeDriver()) {
  get("http://cool-website.com")

  elementByClass("login") {
    sendKeys("user@example.com")
  }

  elementByName("password") {
    sendKeys("123456")
    submit()
  }

  element(By.className("search")) {
    sendKeys("kotlin")
  }

  wait(10) {
    elementVisibilityById("result-item") {
      elementByClass("salary") {
        assert(text == "25000")
      }
    }
  }
}