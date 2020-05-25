import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.LoggerContext

LoggerContext lc = new LoggerContext()

def loggerId = this.getClass().getName()
Logger log = lc.getLogger(loggerId)

log.info("Hello, logback!!")