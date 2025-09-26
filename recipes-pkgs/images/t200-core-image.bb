DESCRIPTION = "Adds Required Packages For Running T200 Firmware"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

# IMAGE_LINGUAS = " "

# TODO: make a PCS license ~ BEF
# LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += " \
    debug-tweaks \
    tools-profile \
    tools-sdk \
    package-management \
    nfs-client \
    tools-debug \
    ssh-server-openssh \
    hwcodecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston','', d)} \
"

SDKIMAGE_FEATURES:append = " \
    staticdev-pkgs \
"
IMAGE_INSTALL += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
    imx-test \
    firmwared \
    packagegroup-imx-core-tools \
    packagegroup-imx-security \
    curl \
    ${CLINFO} \
    ${DOCKER} \
    vim\
    libcbor\
    mosquitto\
    curl\
    lz4\
"
CLINFO              ?= ""
CLINFO:imxgpu        = "clinfo"
CLINFO:mx8mm-nxp-bsp = ""
CLINFO:mx7-nxp-bsp   = ""

DOCKER            ?= ""
DOCKER:mx8-nxp-bsp = "docker"

export IMAGE_BASENAME = "t200-core-image"
