import { Singleton } from "./singleton";

test("Singleton Run", () => {
    const instanceA = Singleton.getInstance();
    const instanceB = Singleton.getInstance();

    expect(instanceA).toBe(instanceB);
});