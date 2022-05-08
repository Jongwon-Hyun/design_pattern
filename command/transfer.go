package command

type transfer struct {
	command func(transferParam TransferParam)
}

func NewTransfer(command func(transferParam TransferParam)) *transfer {
	return &transfer{command: command}
}

func (t transfer) Start(transferParam TransferParam) {
	t.command(transferParam)
}

type TransferParam struct {
	amount  float64
	account string
}

func NewTransferParam(amount float64, account string) TransferParam {
	return TransferParam{amount: amount, account: account}
}
