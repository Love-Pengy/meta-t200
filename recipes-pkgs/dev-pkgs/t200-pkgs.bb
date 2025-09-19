DESCRIPTION = "Adds Required Packages For Running T200 Firmware"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

# IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston','', d)} \
"

IMAGE_INSTALL += " \
    vim\
    libcbor\
    mosquitto\
    curl\
    lz4\
"
export IMAGE_BASENAME = "t200-pkgs"

