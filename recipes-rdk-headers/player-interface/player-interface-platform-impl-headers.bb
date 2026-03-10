SUMMARY = "Soc-specific implementations for player interface"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=97dd37dbf35103376811825b038fc32b"

ALLOW_EMPTY:${PN} = "1"

SRCREV = "269f2b1a38492c26f2f7cfb41d194029a8ea88d2"

SRC_URI = "${CMF_GITHUB_ROOT}/middleware-player-interface;${CMF_GITHUB_SRC_URI_SUFFIX};name=player-interface;branch=develop"

S = "${WORKDIR}/git"
inherit allarch

# this is a HAL package only, nothing to build
do_compile[noexec] = "1"
do_configure[noexec] = "1"

# also get rid of the default dependency added in bitbake.conf
# since there is no 'main' package generated (empty)
RDEPENDS:${PN}-dev = ""

do_install() {
        install -d ${D}${includedir}
        install -m 0644 ${S}/vendor/SocInterface.h  ${D}${includedir}/
        install -m 0644 ${S}/vendor/SocInterfaceImpl.h  ${D}${includedir}/
}
