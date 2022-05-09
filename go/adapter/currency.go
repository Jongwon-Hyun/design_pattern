package adapter

type Currency struct {
	slug string
}

var (
	USD = Currency{slug: "USD"}
	KRW = Currency{slug: "KRW"}
)

func (c Currency) String() string {
	return c.slug
}
