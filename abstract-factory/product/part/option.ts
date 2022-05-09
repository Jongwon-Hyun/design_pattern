const option = {
    navigation: 'navigation',
    audioSystem: 'audio_system',
    cruiseContorl: 'cruise_control'
} as const

type Option = typeof option[keyof typeof option];
const NAVIGATION_OPTION = option.navigation;
const AUDIO_SYSTEM_OPTION = option.audioSystem;
const CRUISE_CONTROL_OPTION = option.cruiseContorl;

export {
    Option, NAVIGATION_OPTION, AUDIO_SYSTEM_OPTION, CRUISE_CONTROL_OPTION,
}