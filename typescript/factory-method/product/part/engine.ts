const engine = {
    gasoline: 'gasoline',
    hybrid: 'hybrid',
} as const

type Engine = typeof engine[keyof typeof engine];
const GASOLINE_ENGINE = engine.gasoline;
const HYBRID_ENGINE = engine.hybrid;

export {
    Engine, GASOLINE_ENGINE, HYBRID_ENGINE
}