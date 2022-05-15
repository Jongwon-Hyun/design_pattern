import { Singleton } from "./singleton";

test("Test Singleton", () => {
    const instanceA = Singleton.getInstance();
    const instanceB = Singleton.getInstance();

    expect(instanceA).toBe(instanceB);
});