package observer

type Subject interface {
	Subscribe(observer Observer)
	Unsubscribe(observer Observer)
	Publish(message string)
}

type messenger struct {
	observerList []Observer
}

func NewMessenger() Subject {
	return &messenger{observerList: []Observer{}}
}

func (m *messenger) Subscribe(observer Observer) {
	if observer != nil {
		m.observerList = append(m.observerList, observer)
	}
}

func (m *messenger) Unsubscribe(observer Observer) {
	var index int
	for i, o := range m.observerList {
		if o.GetName() == observer.GetName() {
			index = i
		}
	}
	m.observerList = append(m.observerList[:index], m.observerList[index+1:]...)
}

func (m messenger) Publish(message string) {
	for _, o := range m.observerList {
		o.Update(message)
	}
}
