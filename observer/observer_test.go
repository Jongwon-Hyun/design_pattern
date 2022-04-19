package observer_test

import (
	"design_pattern/observer"
	"testing"
)

func TestObserver(t *testing.T) {
	t.Run("Observer run", func(t *testing.T) {
		messenger := observer.NewMessenger()
		mailSender := observer.NewMailSender()
		appAlarmSender := observer.NewAppAlarmSender()

		messenger.Subscribe(mailSender)
		messenger.Subscribe(appAlarmSender)

		messenger.Publish("Show me the Money!")

		messenger.Unsubscribe(appAlarmSender)

		messenger.Publish("Give me the Money!")
	})
}
