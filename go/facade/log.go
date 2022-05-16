package facade

import "fmt"

type Log interface {
	Info(message string)
	Warn(message string)
	Fatal(message string)
}

type consoleLog struct{}

func NewConsoleLog() Log {
	return &consoleLog{}
}

func (c consoleLog) Info(message string) {
	fmt.Println("INFO : " + message)
}

func (c consoleLog) Warn(message string) {
	fmt.Println("WARN : " + message)
}

func (c consoleLog) Fatal(message string) {
	fmt.Println("FATAL : " + message)
}
