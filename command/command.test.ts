import { AbcBank } from "./receiver/abc_bank";
import { XyzBank } from "./receiver/xyz_bank";
import { Transfer } from "./transfer";

test('Command Run', () => {
    const arrayLikeQueue = new Array<Transfer>();

    const abcBank = new AbcBank();
    const transferToAbcBank = new Transfer(transferParam => abcBank.transfer(transferParam));
    arrayLikeQueue.push(transferToAbcBank);

    const xyzBank = new XyzBank();
    const transferToXyzBank = new Transfer(transferParam => xyzBank.transfer(transferParam));
    arrayLikeQueue.push(transferToXyzBank);

    while (arrayLikeQueue.length > 0) {
        const transfer = arrayLikeQueue.shift();
        transfer.start({
            amount: 123.45,
            account: '012345',
        })
    }
});