package command

import "testing"

func TestCommand(t *testing.T) {
	t.Run("Command Run", func(t *testing.T) {
		ch := make(chan *transfer, 2)

		abcBank := NewAbcBank()
		transferToAbcBank := NewTransfer(func(transferParam TransferParam) {
			err := abcBank.Transfer(transferParam)
			if err != nil {
				t.Error(err)
			}
		})
		ch <- transferToAbcBank

		xyzBank := NewXyzBank()
		transferToXyzBank := NewTransfer(func(transferParam TransferParam) {
			xyzBank.Transfer(transferParam)
		})
		ch <- transferToXyzBank

		close(ch)

		for transfer := range ch {
			transfer.Start(NewTransferParam(123.45, "012345"))
		}
	})
}
