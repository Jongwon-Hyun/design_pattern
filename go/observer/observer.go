package observer

import "fmt"

type Observer interface {
	Update(message string)
	GetName() string
}

type mailSender struct {
	name string
}

func NewMailSender() Observer {
	return &mailSender{name: "mailSender"}
}

func (m mailSender) Update(message string) {
	m.sendMail(message)
}

func (m mailSender) GetName() string {
	return m.name
}

func (m mailSender) sendMail(message string) {
	// 메일러 등의 서드파티 라이브러리로 메일 전송
	fmt.Println("Mail : " + message)
}

type appAlarmSender struct {
	name string
}

func NewAppAlarmSender() Observer {
	return &appAlarmSender{name: "appAlarmSender"}
}

func (a appAlarmSender) Update(message string) {
	a.pushAlarm(message)
}

func (a appAlarmSender) GetName() string {
	return a.name
}

func (a appAlarmSender) pushAlarm(message string) {
	// 파이어베이스 클라우드 메시징 등의 서드파티 라이브러리로 앱에 푸쉬
	fmt.Println("App Alarm : " + message)
}
