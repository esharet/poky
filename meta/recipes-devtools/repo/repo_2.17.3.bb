# SPDX-License-Identifier: MIT
# Copyright (C) 2021 iris-GmbH infrared & intelligent sensors

SUMMARY = "Tool for managing many Git repositories"
DESCRIPTION = "Repo is a tool built on top of Git. Repo helps manage many Git repositories, does the uploads to revision control systems, and automates parts of the development workflow."
HOMEPAGE = "https://android.googlesource.com/tools/repo"
SECTION = "console/utils"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "git://gerrit.googlesource.com/git-repo.git;protocol=https;branch=main"
SRCREV = "11b30b91df1f0e03b53da970ec2588e85817bacc"

SRC_URI += "file://0001-python3-shebang.patch \
            file://0001-Set-REPO_REV-to-v2.17.3.patch"

MIRRORS += "git://gerrit.googlesource.com/git-repo.git git://github.com/GerritCodeReview/git-repo.git"

S = "${WORKDIR}/git"

do_install() {
	install -D ${WORKDIR}/git/repo ${D}${bindir}/repo
}

RDEPENDS:${PN} = "python3 git"

BBCLASSEXTEND = "native nativesdk"
