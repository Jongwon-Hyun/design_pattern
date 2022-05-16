package facade

import "fmt"

type Notification struct{}

func NewNotification() *Notification {
	return &Notification{}
}

func (n Notification) SendEmail(message string) {
	fmt.Println("메일 전송 : " + message)
}

func (n Notification) SendAppPush(message string) {
	fmt.Println("앱 푸쉬 : " + message)
}
